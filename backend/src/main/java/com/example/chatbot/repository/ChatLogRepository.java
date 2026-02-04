package com.example.chatbot.repository;

import com.example.chatbot.entity.ChatLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * チャットログリポジトリ
 */
@Repository
public interface ChatLogRepository extends JpaRepository<ChatLog, Long> {
    
    /**
     * 作成日時の降順でチャットログを取得
     */
    List<ChatLog> findAllByOrderByCreatedAtDesc();
}
