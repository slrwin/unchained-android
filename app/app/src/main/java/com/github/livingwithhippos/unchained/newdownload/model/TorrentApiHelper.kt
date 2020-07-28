package com.github.livingwithhippos.unchained.newdownload.model

import okhttp3.RequestBody
import retrofit2.Response

interface TorrentApiHelper {

    suspend fun getAvailableHosts(token: String): Response<List<AvailableHost>>


    suspend fun getTorrentInfo(
        token: String,
        id: String
    ): Response<TorrentItem>

    suspend fun addTorrent(
        token: String,
        binaryTorrent: RequestBody,
        host: String
    ): Response<UploadedTorrent>

    suspend fun addMagnet(
        token: String,
        magnet: String,
        host: String
    ): Response<UploadedTorrent>

    suspend fun getTorrentsList(
        token: String,
        offset: Int?,
        page: Int?,
        limit: Int?,
        filter: String?
    ): Response<List<TorrentItem>>

    suspend fun selectFiles(
        token: String,
        id: String,
        files: String
    ): Response<Unit>
}