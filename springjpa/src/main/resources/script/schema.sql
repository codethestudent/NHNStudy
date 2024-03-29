CREATE TABLE Categories
(
    CategoryID   INT auto_increment,
    CategoryName varchar(50),

    CONSTRAINT pk_Categories PRIMARY KEY (CategoryID)
);

CREATE TABLE Products
(
    ProductID    INT auto_increment,
    CategoryID   INT,
    ModelNumber  nvarchar(10),
    ModelName    nvarchar(120),
    ProductImage nvarchar(30),
    UnitCost     decimal(15),
    Description  text,

    CONSTRAINT pk_Products PRIMARY KEY (ProductID),
    CONSTRAINT fk_Products_Categories FOREIGN KEY (CategoryID) REFERENCES Categories (CategoryID)
);

CREATE TABLE `users`
(
    `user_id`         varchar(50)  NOT NULL COMMENT '아이디',
    `user_name`       varchar(50)  NOT NULL COMMENT '이름',
    `user_password`   varchar(200) NOT NULL COMMENT 'mysql password 사용',
    `user_birth`      varchar(8)   NOT NULL COMMENT '생년월일 : 19840503',
    `user_auth`       varchar(10)  NOT NULL COMMENT '권한: ROLE_ADMIN,ROLE_USER',
    `user_point`      int          NOT NULL COMMENT 'default : 1000000',
    `created_at`      datetime     NOT NULL COMMENT '가입일자',
    `latest_login_at` datetime DEFAULT NULL COMMENT '마지막 로그인 일자',
    PRIMARY KEY (`user_id`)
);

CREATE TABLE Reviews
(
    ReviewID  int auto_increment,
    ProductID int,
    user_id   varchar(50),
    Rating    int,
    Comments  text,

    CONSTRAINT pk_ReviewID PRIMARY KEY (ReviewID),
    CONSTRAINT fk_Review_Products FOREIGN KEY (ProductID) REFERENCES Products (ProductID),
    CONSTRAINT fk_Review_Customer FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE Orders
(
    OrderID   int auto_increment,
    user_id   varchar(50),
    OrderDate Datetime,
    ShipDate  Datetime,

    CONSTRAINT pk_Orders PRIMARY KEY (OrderID),
    CONSTRAINT fk_Orders_CustomerID FOREIGN KEY (user_id) REFERENCES users (user_id)
);
CREATE TABLE Address
(
    AddressID   int auto_increment PRIMARY KEY,
    AddressName varchar(255) NOT NULL,
    user_id     varchar(50),

    CONSTRAINT fk_Address_User FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE OrderDetails
(
    OrderID   int,
    ProductID int,
    Quantity  int,
    UnitCost  decimal(15),
    AddressID int,

    CONSTRAINT pk_OrderDetails PRIMARY KEY (OrderID, ProductID),
    CONSTRAINT fk_OrderDetails_Orders FOREIGN KEY (OrderID) REFERENCES Orders (OrderID),
    CONSTRAINT fk_OrderDetails_Products FOREIGN KEY (ProductID) REFERENCES Products (ProductID),
    CONSTRAINT fk_OrderDetails_Address FOREIGN KEY (AddressID) REFERENCES Address (AddressID)
);

CREATE TABLE ShoppingCart
(
    RecordID     int auto_increment,
    CartID       nvarchar(150),
    Quantity     int,
    ProductID    int,
    DateCreateed Datetime DEFAULT NOW(),

    CONSTRAINT pk_RecordID PRIMARY KEY (RecordID),
    CONSTRAINT fk_cart_ProductID FOREIGN KEY (ProductID) REFERENCES Products (ProductID)
);

INSERT INTO Categories (CategoryName)
VALUES ('Electronics'), ('Books');

INSERT INTO Products (CategoryID, ModelNumber, ModelName, ProductImage, UnitCost, Description)
VALUES (1, 'ELEC1234', 'Electronic Gadget', 'image1.jpg', 100.00, 'An electronic gadget description'),
       (2, 'BOOK1234', 'Book Title', 'image2.jpg', 50.00, 'A book description');

INSERT INTO users (user_id, user_name, user_password, user_birth, user_auth, user_point, created_at)
VALUES ('user1', 'Test User 1', 'password', '19800101', 'ROLE_USER', 1000, NOW()),
       ('user2', 'Test User 2', 'password', '19800102', 'ROLE_USER', 2000, NOW());

INSERT INTO Orders (user_id, OrderDate, ShipDate)
VALUES ('user1', NOW(), NOW()),
       ('user2', NOW(), NOW());
INSERT INTO OrderDetails (OrderID, ProductID, Quantity, UnitCost)
VALUES (1, 1, 10, 100.00), -- ProductID 1 참조
       (2, 2, 3, 50.00); -- ProductID 2 참조