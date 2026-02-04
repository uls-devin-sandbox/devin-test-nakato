<template>
  <el-card class="chatbot-card">
    <template #header>
      <div class="card-header">
        <span>チャットボット</span>
      </div>
    </template>
    
    <div class="chat-container">
      <!-- チャット履歴表示エリア -->
      <div class="chat-history">
        <div v-for="(chat, index) in chatHistory" :key="index" class="chat-message">
          <div class="user-message">
            <span class="label">ユーザー:</span> {{ chat.userInput }}
          </div>
          <div class="bot-message">
            <span class="label">ボット:</span> {{ chat.botResponse }}
          </div>
        </div>
        <div v-if="chatHistory.length === 0" class="no-history">
          チャット履歴がありません。名前を入力してください。
        </div>
      </div>
      
      <!-- 入力エリア -->
      <div class="input-area">
        <el-input
          v-model="nameInput"
          placeholder="名前を入力してください..."
          @keyup.enter="sendMessage"
          class="name-input"
        />
        <el-button 
          type="primary" 
          @click="sendMessage" 
          :loading="loading"
          class="send-button"
        >
          送信
        </el-button>
      </div>
    </div>
  </el-card>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import axios from 'axios'

interface ChatLog {
  userInput: string
  botResponse: string
  createdAt: string
}

const nameInput = ref('')
const chatHistory = ref<ChatLog[]>([])
const loading = ref(false)

const sendMessage = async () => {
  if (!nameInput.value.trim()) {
    return
  }
  
  loading.value = true
  
  try {
    const response = await axios.post('/api/chat', {
      name: nameInput.value
    })
    
    // 新しいメッセージを履歴に追加
    chatHistory.value.unshift({
      userInput: nameInput.value,
      botResponse: response.data.message,
      createdAt: response.data.timestamp
    })
    
    // 入力をクリア
    nameInput.value = ''
  } catch (error) {
    console.error('チャット送信エラー:', error)
  } finally {
    loading.value = false
  }
}

const loadHistory = async () => {
  try {
    const response = await axios.get('/api/chat/history')
    chatHistory.value = response.data
  } catch (error) {
    console.error('履歴取得エラー:', error)
  }
}

onMounted(() => {
  loadHistory()
})
</script>

<style scoped>
.chatbot-card {
  width: 500px;
  max-width: 100%;
}

.card-header {
  font-size: 18px;
  font-weight: bold;
  text-align: center;
}

.chat-container {
  display: flex;
  flex-direction: column;
  gap: 16px;
}

.chat-history {
  height: 300px;
  overflow-y: auto;
  border: 1px solid #e4e7ed;
  border-radius: 4px;
  padding: 12px;
  background-color: #fafafa;
}

.chat-message {
  margin-bottom: 12px;
  padding-bottom: 12px;
  border-bottom: 1px solid #eee;
}

.chat-message:last-child {
  border-bottom: none;
  margin-bottom: 0;
  padding-bottom: 0;
}

.user-message,
.bot-message {
  padding: 4px 0;
}

.label {
  font-weight: bold;
  color: #409eff;
}

.bot-message .label {
  color: #67c23a;
}

.no-history {
  color: #909399;
  text-align: center;
  padding: 20px;
}

.input-area {
  display: flex;
  gap: 8px;
}

.name-input {
  flex: 1;
}

.send-button {
  background-color: #000000;
  border-color: #000000;
  color: #ffffff;
}

.send-button:hover {
  background-color: #333333;
  border-color: #333333;
}
</style>
