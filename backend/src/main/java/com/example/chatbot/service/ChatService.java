package com.example.chatbot.service;

import com.example.chatbot.dto.ChatRequest;
import com.example.chatbot.dto.ChatResponse;
import com.example.chatbot.entity.ChatLog;
import com.example.chatbot.repository.ChatLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * チャットサービス
 */
@Service
public class ChatService {

    private final ChatLogRepository chatLogRepository;

    public ChatService(ChatLogRepository chatLogRepository) {
        this.chatLogRepository = chatLogRepository;
    }

    /**
     * チャットメッセージを処理し、応答を返す
     * 
     * @param request チャットリクエスト
     * @return チャットレスポンス
     */
    public ChatResponse processChat(ChatRequest request) {
        String name = request.getName();
        String responseMessage = "Hello, " + name;
        LocalDateTime now = LocalDateTime.now();

        // チャットログをDBに保存
        ChatLog chatLog = new ChatLog(name, responseMessage);
        chatLogRepository.save(chatLog);

        return new ChatResponse(responseMessage, now);
    }

    /**
     * チャット履歴を取得
     * 
     * @return チャットログのリスト
     */
    public List<ChatLog> getChatHistory() {
        return chatLogRepository.findAllByOrderByCreatedAtDesc();
    }
}
