package com.github.livingwithhippos.unchained.base.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.github.livingwithhippos.unchained.base.model.entities.Credentials

@Dao
interface CredentialsDao {

    @Query("SELECT * FROM credentials WHERE device_code = :deviceCode")
    suspend fun getCredentials(deviceCode: String): Credentials?

    @Query("SELECT * from credentials")
    suspend fun getAllCredentials(): List<Credentials>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(credentials: Credentials)

    @Query("UPDATE credentials SET client_id = :clientId AND client_secret = :clientSecret WHERE device_code = :deviceCode")
    suspend fun updateSecrets(deviceCode: String, clientId: String, clientSecret: String)

    @Query("UPDATE credentials SET access_token = :accessToken AND refresh_token = :refreshToken WHERE device_code = :deviceCode")
    suspend fun updateToken(deviceCode: String, accessToken: String, refreshToken: String)

    @Query("DELETE FROM credentials")
    suspend fun deleteAll()

    @Query("DELETE FROM credentials WHERE device_code = :deviceCode")
    suspend fun delete(deviceCode: String)
}