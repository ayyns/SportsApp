package com.dicoding.core.di

import androidx.room.Room
import com.dicoding.core.data.source.local.LocalDataSource
import com.dicoding.core.data.source.local.room.SportsDatabase
import com.dicoding.core.data.source.remote.RemoteDataSource
import com.dicoding.core.data.source.remote.network.ApiService
import com.dicoding.core.domain.repository.ISportsRepository
import com.dicoding.core.utils.AppExecutors
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<SportsDatabase>().tourismDao() }
    single {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("Sports".toCharArray())
        val factory = SupportFactory(passphrase)
        Room.databaseBuilder(
            androidContext(),
            SportsDatabase::class.java, "Sports.db"
        ).openHelperFactory(factory).build()
    }
}

val networkModule = module {
    single {
        val hostname = "tourism-api.dicoding.dev"
        val certificatePinner = CertificatePinner.Builder()
            .add(hostname, "sha256/vyrlXYCW/dYlo5xgY3p95vfLWDkUBmQSetj1TfMQGiE=")
            .add(hostname, "sha256/K7rZOrXHknnsEhUH8nLL4MZkejquUuIvOIr6tCa0rbo=")
            .add(hostname, "sha256/C5+lpZ7tcVwmwQIMcRtPbsQtWLABXhQzejna0wHFr8M=")
            .build()
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .certificatePinner(certificatePinner)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.thesportsdb.com/api/v1/json/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<ISportsRepository> { com.dicoding.core.data.SportsRepository(get(), get(), get()) }
}