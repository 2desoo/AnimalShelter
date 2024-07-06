package AnimalShelter.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class UserMessages {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long chatId;
    private LocalDateTime messagesData;
    private String massagesText;

    public UserMessages() {}

    public Long getId() {
        return id;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public LocalDateTime getMessagesData() {
        return messagesData;
    }

    public void setMessagesData(LocalDateTime messagesData) {
        this.messagesData = messagesData;
    }

    public String getMassagesText() {
        return massagesText;
    }

    public void setMassagesText(String massagesText) {
        this.massagesText = massagesText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserMessages that = (UserMessages) o;
        return Objects.equals(id, that.id) && Objects.equals(chatId, that.chatId) && Objects.equals(messagesData, that.messagesData) && Objects.equals(massagesText, that.massagesText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chatId, messagesData, massagesText);
    }

    @Override
    public String toString() {
        return "UserMessages{" +
                "id=" + id +
                ", chatId=" + chatId +
                ", messagesData=" + messagesData +
                ", massagesText='" + massagesText + '\'' +
                '}';
    }
}
