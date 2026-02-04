package com.example.chatbot.controller;

import com.example.chatbot.dto.ChatRequest;
import com.example.chatbot.dto.ChatResponse;
import com.example.chatbot.entity.ChatLog;
import com.example.chatbot.service.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * チャットコントローラー
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    /**
     * チャットメッセージを送信
     * 
     * @param request チャットリクエスト
     * @return チャットレスポンス
     */
    @PostMapping("/chat")
    public ResponseEntity<ChatResponse> chat(@RequestBody ChatRequest request) {
        ChatResponse response = chatService.processChat(request);
        return ResponseEntity.ok(response);
    }

    /**
     * チャット履歴を取得
     * 
     * @return チャットログのリスト
     */
    @GetMapping("/chat/history")
    public ResponseEntity<List<ChatLog>> getChatHistory() {
        List<ChatLog> history = chatService.getChatHistory();
        return ResponseEntity.ok(history);
    }
}
