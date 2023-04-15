-- 生成测试数据
INSERT INTO `users`
(`id`, `username`, `password`, `user_following_json`, `nickname`, `role`, `avatar`, `email`, `phone`, `gender`, `status`, `create_time`, `update_time`)
VALUES
    (1, 'user1', 'password1', '["2","3"]', 'nick1', 1, 'avatar1.png', 'user1@example.com', '12345678901', 1, 1, '2023-04-01 10:00:00', '2023-04-01 10:00:00'),
    (2, 'user2', 'password2', '["3","4"]', 'nick2', 1, 'avatar2.png', 'user2@example.com', '12345678902', 2, 1, '2023-04-02 10:00:00', '2023-04-02 10:00:00'),
    (3, 'user3', 'password3', '["5","3"]', 'nick3', 2, 'avatar3.png', 'user3@example.com', '12345678903', 1, 1, '2023-04-03 10:00:00', '2023-04-03 10:00:00'),
    (4, 'user4', 'password4', '[]', 'nick4', 1, 'avatar4.png', 'user4@example.com', '12345678904', 2, 1, '2023-04-04 10:00:00', '2023-04-04 10:00:00'),
    (5, 'user5', 'password5', '[]', 'nick5', 1, 'avatar5.png', 'user5@example.com', '12345678905', 1, 1, '2023-04-05 10:00:00', '2023-04-05 10:00:00');

