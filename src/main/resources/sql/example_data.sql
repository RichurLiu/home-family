INSERT INTO family_information (family_id,family_name,family_description,is_delete,create_time,update_time) VALUES
('c66e12c1-ef06-423e-b447-3be021084d64','example','描述',0,'2023-01-02 09:38:33','2023-01-02 09:38:58');

INSERT INTO family_member_information (user_id,nickname,username,appellation,score,family_id,is_delete,create_time,update_time) VALUES
('64c4ff60-b0f5-4121-b025-f63c3e98d1a6','baba','小刘','爸爸',4,'c66e12c1-ef06-423e-b447-3be021084d64',0,'2023-01-02 12:11:40','2023-01-03 12:58:06'),
('f639b993-0513-4f0d-bd1e-cd5d3684dba2','mama','小王','妈妈',5,'c66e12c1-ef06-423e-b447-3be021084d64',0,'2023-01-02 12:12:23','2023-01-02 12:12:23');

INSERT INTO family_member_score_detail (user_id,change_description,work_user_id,score,is_delete,create_time,update_time) VALUES
('f639b993-0513-4f0d-bd1e-cd5d3684dba2','vina让richur洗车厘子','64c4ff60-b0f5-4121-b025-f63c3e98d1a6',1,0,'2023-01-01 15:20:13','2023-01-01 15:20:13'),
('f639b993-0513-4f0d-bd1e-cd5d3684dba2','剪刀石头布获取','',6,0,'2023-01-01 15:16:25','2023-01-01 15:16:25'),
('64c4ff60-b0f5-4121-b025-f63c3e98d1a6','剪刀石头布获取','',4,0,'2023-01-01 15:16:25','2023-01-01 15:16:25');