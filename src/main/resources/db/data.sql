INSERT INTO bank_user (
    id, username, password, first_name, last_name, email, phone_number, address, city, country,
    postal_code, oib, iban, account_number, balance, currency, role, enabled, token,
    token_expiration_date, last_login_date, last_login_ip, last_login_location,
    last_login_browser, last_login_os, last_login_device, last_login_device_type,
    last_login_device_brand, last_login_device_model, last_login_device_browser,
    last_login_device_os, last_login_device_os_version, last_login_device_browser_version
) VALUES (
    'integer in db showing how many users there are', 'crystalclear', 'plaintext-password', 'Crystal', 'Clear', 'crystalclear@example.com', '555-1234', '123 Main St',
    'Anytown', 'USA', '12345', '12345678901', 'HR1210010051863000160', '987654321', 5000.75, 'USD',
    'USER', true, 'token', '2023-12-31', '2022-01-01', '192.168.1.1', 'New York', 'Chrome',
    'Windows', 'Crystals PC', 'Desktop', 'Dell', 'XPS 15', 'Chrome', 'Windows', '10', '87.0.4280.88'
);

INSERT INTO google_search (id, search_text) VALUES
(1, 'Bubamara'),
(2, 'Mandarina'),
(3, 'Lazna poruka<strong style="color: red;">This is a demonstration of an XSS attack.</strong>');

SELECT setval('google_search_seq', 3, true);