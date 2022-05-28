package com.example.myapp.di.modules

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.myapp.data.api.ApiHelper
import com.example.myapp.data.api.ApiHelperImpl
import com.example.myapp.data.api.ApiInfo
import com.example.myapp.data.api.ApiService
import com.example.myapp.data.room.AppDatabase
import com.example.myapp.data.room.dao.UserDao
import com.example.myapp.di.ActivityScope
import com.example.myapp.di.ApplicationContext
import com.example.myapp.di.ViewModelKey
import com.example.myapp.ui.ViewModelFactory
import com.example.myapp.ui.activities.MainActivity
import com.example.myapp.ui.fragments.person.PersonViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

//Use @Binds to tell Dagger which implementation it needs to use when providing an interface or abstract class
@Module
internal interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(PersonViewModel::class)
    fun personViewModel(viewModel: PersonViewModel): ViewModel

    @Binds
    fun viewModelFactory(viewModelFactory: ViewModelFactory):
        ViewModelProvider.Factory
}

@Module
interface ActivityBuilder {
    @ContributesAndroidInjector(modules = [ActivityModule::class, FragmentBuilder::class])
    @ActivityScope
    fun MainActivity(): MainActivity
}



@Module
internal class RetrofitModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        try {
            // Create a trust manager that does not validate certificate chains
            val trustAllCerts = arrayOf<TrustManager>(
                @SuppressLint("CustomX509TrustManager")
                object : X509TrustManager {
                    @SuppressLint("TrustAllX509TrustManager")
                    @Throws(CertificateException::class)
                    override fun checkClientTrusted(
                        chain: Array<X509Certificate>,
                        authType: String,
                    ) {
                    }

                    @SuppressLint("TrustAllX509TrustManager")
                    @Throws(CertificateException::class)
                    override fun checkServerTrusted(
                        chain: Array<X509Certificate>,
                        authType: String,
                    ) {
                    }

                    override fun getAcceptedIssuers(): Array<X509Certificate> {
                        return arrayOf()
                    }
                })

            // Install the all-trusting trust manager
            val sslContext =
                SSLContext.getInstance("SSL")
            sslContext.init(null, trustAllCerts, SecureRandom())

            // Create an ssl socket factory with our all-trusting manager
            val sslSocketFactory = sslContext.socketFactory

            // Create an loggingInterceptor
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            return OkHttpClient.Builder()
                .sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
                .hostnameVerifier { _, _ -> true }
                .addInterceptor(logging)
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(ApiInfo.BASE_URL)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

//for optimization use below
  /*  @Provides
    @Singleton
    fun provideApiHelper(apiHelper: ApiHelperImpl): ApiHelper = apiHelper*/
}
//for optimization
@Module
internal interface NetworkModule {
    @Binds
    @Singleton
    fun provideApiHelper(apiHelper: ApiHelperImpl): ApiHelper
}
@Module
internal class RoomModule() {
    @Singleton
    @Provides
    fun getUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao
    }

    @Singleton
    @Provides
    fun getRoomDbInstance(@ApplicationContext application: Context): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "app_db")
            .fallbackToDestructiveMigration()
            .build()
    }

}