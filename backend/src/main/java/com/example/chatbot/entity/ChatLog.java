package com.example.chatbot.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * チャットログエンティティ
 * ユーザーの入力とボットの応答を記録する
 */
@Entity
@Table(name = "chat_logs")
public class ChatLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_input", nullable = false)
    private String userInput;

    @Column(name = "bot_response", nullable = false)
    private String botResponse;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public ChatLog() {
    }

    public ChatLog(String userInput, String botResponse) {
        this.userInput = userInput;
        this.botResponse = botResponse;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public String getBotResponse() {
        return botResponse;
    }

    public void setBotResponse(String botResponse) {
        this.botResponse = botResponse;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
