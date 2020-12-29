package com.murat.invio.network.services

import com.murat.invio.network.responses.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiServices {

    @GET("/api/newspaper/list/")
    suspend fun getNewspapers(): NewspaperResponse

    @POST("/api/v2/search/")
    suspend fun getAuthors(
        @Body request: HashMap<String, String>
    ): AuthorResponse

    @POST("/api/v2/search/")
    suspend fun getNewspaperAuthors(
        @Body request: HashMap<String, String>,
        @Body request2: HashMap<String, Int>
    ): AuthorResponse

    @POST("/api/v2/search/")
    suspend fun getArticles(
        @Body request2: HashMap<String, String>
    ): ArticleResponse

    @GET("/api/author/article/list/{author_id}/{pagenumber}/")
    suspend fun getAuthorArticles(
        @Path("author_id") authorId: Int,
        @Path("pagenumber")pagenumber:Int): AuthorArticleResponse

    @POST("/api/client/data/")
    suspend fun postClient(
        @Body request: ClientRequest
    ): ClientResponse

    @POST("/api/client/favorites/action/")
    suspend fun postClientAuthorFavorite(
        @Body request: AuthorFavoriteRequest
    ): AuthorFavoriteResponse

    @POST("/api/client/get/favorites/authors/")
    suspend fun getFavoriteAuthors(
        @Body request: HashMap<String, String>
    ): AuthorResponse

    @POST("/api/client/read/later/")
    suspend fun postClientArticleReadLater(
        @Body request: ArticleReadLaterRequest
    ): ArticleReadLaterResponse

    @POST("api/client/article/favorites/action/")
    suspend fun favoriArticle(
        @Body request: ArticleReadLaterRequest
    ): ArticleReadLaterResponse

    @POST("api/article/inc/read/count/mobile/")
    suspend fun readCount(
        @Body request: ArticleReadLaterRequest
    ): ArticleReadLaterResponse


}