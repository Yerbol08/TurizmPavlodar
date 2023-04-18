import android.telecom.Call

interface TelegramApiService {
    @GET("bot{botToken}/sendMessage")
    fun sendMessage(
        @Path("botToken") botToken: String,
        @Query("chat_id") chatId: String,
        @Query("text") text: String
    ): Call<TelegramResponse>
}