DROP TABLE IF EXISTS user_accounts

CREATE TABLE user_accounts(
  id INT PRIMARY KEY,
  name VARCHAR(150) NOT NULL,
  phone INT NOT NULL,
  email VARCHAR(200) NOT NULL,
  address VARCHAR(200) DEFAULT NULL,
  country VARCHAR(56) NOT NULL,
  department VARCHAR(50) NOT NULL
);

INSERT INTO user_accounts (id, name, phone, email, address, country, department) VALUES
  (1, 'Guneykan', 5353235445,'guneykan.ince@gmail.com', 'Merdivenkoy', 'Turkey', 'ATM');
