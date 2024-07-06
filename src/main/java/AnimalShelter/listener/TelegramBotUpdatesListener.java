package AnimalShelter.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelegramBotUpdatesListener implements UpdatesListener {

    private Logger logger = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);

    @Autowired
    private TelegramBot telegramBot;

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    @Override
    public int process(List<Update> updates) {
        updates.forEach(update -> {
            logger.info("Processing update: {}", update);
            String updateMessageText = update.message().text();
            Long chatId = update.message().chat().id();

            if (updateMessageText == null) {
                logger.warn("Message is null, {}", update);
                return;
            }

            String messageText = "Добро пожаловать в бот приюта для собак.\n" +
                    "Здесь вы сможете узнать основную информацию о приюте.";

            if (update.message() != null && updateMessageText.equals("/start")) {
                sendMessage(chatId,messageText);
            }

        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

    private void sendMessage(long chatId, String messageText) {
        SendMessage message = new SendMessage(chatId, messageText);
        try {
            telegramBot.execute(message);
        } catch (Exception e) {
            logger.error("Error sending message", e);
        }
    }
}
