-- 테이블 생성
CREATE TABLE product
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    price       INT          NOT NULL,
    stock       INT          NOT NULL,
    description TEXT,
    image       VARCHAR(255),
    createdAt   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updatedAt   TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Mock 데이터 삽입
INSERT INTO product (name, price, stock, description)
VALUES ('아이스크림', 1000, 100, '맛있는 아이스크림'),
       ('초코파이', 500, 50, '달콤한 초코파이'),
       ('컵라면', 800, 200, '매운 컵라면'),
       ('삼각김밥', 1200, 300, '간편한 삼각김밥'),
       ('펩시콜라', 1500, 150, '시원한 펩시콜라');
