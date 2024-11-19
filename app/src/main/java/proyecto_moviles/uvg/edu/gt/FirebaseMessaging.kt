package proyecto_moviles.uvg.edu.gt

class FirebaseMessaging: FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        super.onNewToken(token)

        println("FCM token: $token")
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        message.notification?.let { notification ->
            println("${notification.title}, ${notification.body}")
        }
    }
}