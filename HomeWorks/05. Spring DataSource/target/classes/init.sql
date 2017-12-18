CREATE TABLE films (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  name TEXT NOT NULL,
  description TEXT 
);

INSERT INTO films (name, description) VALUES 
  ('Avengers', NULL),
  ('Iron Man', NULL);