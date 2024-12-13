-- Inserting data into task_lists table
INSERT INTO task_lists (id, title, description, created, updated) VALUES
  ('3f85a9ad-bc5a-4db7-8a6e-bcde5a6f07a1', 'Personal Tasks', 'Tasks related to personal goals and activities', '2024-12-01 09:00:00', '2024-12-01 09:00:00'),
  ('f45d3cb3-2d44-466e-b0b5-0e94cfd645f5', 'Work Projects', 'Tasks related to work assignments and projects', '2024-12-01 10:00:00', '2024-12-01 10:00:00');

-- Inserting data into tasks table
INSERT INTO tasks (id, title, description, due_date, status, priority, task_list_id, created_at, updated_at) VALUES
  ('c9adbcaf-56d4-47db-8dbb-d9c0056e22c5', 'Buy groceries', 'Purchase vegetables, fruits, and other essentials', '2024-12-15 17:00:00', '0', '1', '3f85a9ad-bc5a-4db7-8a6e-bcde5a6f07a1', '2024-12-01 09:30:00', '2024-12-01 09:30:00'),
  ('5cfa4692-78f9-42e5-b623-57bc3bc1a926', 'Prepare presentation', 'Work on the quarterly business presentation', '2024-12-18 09:00:00', '0', '2', 'f45d3cb3-2d44-466e-b0b5-0e94cfd645f5', '2024-12-01 10:15:00', '2024-12-01 10:15:00'),
  ('a2f9e39a-9b79-4c15-a762-e8a4ccf58d2d', 'Call plumber', 'Fix the leaking faucet in the kitchen', '2024-12-12 15:00:00', '1', '0', '3f85a9ad-bc5a-4db7-8a6e-bcde5a6f07a1', '2024-12-01 09:45:00', '2024-12-01 09:45:00'),
  ('9a62d748-b8b3-4a15-924e-7c3f9161c7c6', 'Submit report', 'Submit the annual performance report to the manager', '2024-12-10 18:00:00', '0', '2', 'f45d3cb3-2d44-466e-b0b5-0e94cfd645f5', '2024-12-01 10:30:00', '2024-12-01 10:30:00');
