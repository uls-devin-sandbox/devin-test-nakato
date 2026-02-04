# チャットボットアプリ

名前を入力すると「Hello, ○○」と返信するシンプルなチャットボットアプリケーションです。
ユーザーの入力はデータベースに記録されます。

## 技術スタック

### フロントエンド
- Vue 3
- TypeScript
- Element Plus
- Vite

### バックエンド
- Spring Boot 3.4
- Java 17
- H2 Database（組み込み）
- Spring Data JPA

## ディレクトリ構成

```
devin-test-nakato/
├── design/                 # 設計ドキュメント
│   └── chatbot-design.md
├── frontend/               # フロントエンド（Vue 3）
│   ├── src/
│   │   ├── App.vue
│   │   ├── main.ts
│   │   └── components/
│   │       └── ChatBot.vue
│   ├── index.html
│   ├── package.json
│   ├── tsconfig.json
│   └── vite.config.ts
├── backend/                # バックエンド（Spring Boot）
│   ├── src/main/java/com/example/chatbot/
│   │   ├── ChatbotApplication.java
│   │   ├── controller/
│   │   ├── service/
│   │   ├── repository/
│   │   ├── entity/
│   │   └── dto/
│   ├── src/main/resources/
│   │   └── application.properties
│   └── pom.xml
└── README.md
```

## 起動方法

### バックエンド

```bash
cd backend
mvn spring-boot:run
```

バックエンドは http://localhost:8080 で起動します。

### フロントエンド

```bash
cd frontend
npm install
npm run dev
```

フロントエンドは http://localhost:5173 で起動します。

## 機能

1. **チャット機能**: 名前を入力すると「Hello, ○○」と返信
2. **履歴機能**: チャット履歴をデータベースに保存・表示
