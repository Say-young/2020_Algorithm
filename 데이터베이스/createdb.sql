CREATE TABLE FirstCategory (
idx INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
first VARCHAR(30) NOT NULL
);

CREATE TABLE SecondCategory (
idx INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
second VARCHAR(30) NOT NULL
);

create table Information (
idx INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30) NOT NULL UNIQUE,
price INT NOT NULL,
firstCategoryIdx INT NOT NULL,
secondCategoryIdx INT NOT NULL,
FOREIGN KEY(firstCategoryIdx) references FirstCategory(idx) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY(secondCategoryIdx) references SecondCategory(idx) ON DELETE CASCADE ON UPDATE CASCADE
);

create index menu_index on information(name);

create table Caution (
idx INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30) NOT NULL,
content VARCHAR(100) NOT NULL,
FOREIGN KEY(name) references Information(name) ON DELETE CASCADE ON UPDATE CASCADE
);

create table PersonalOption (
idx INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30) NOT NULL,
content VARCHAR(100) NOT NULL,
FOREIGN KEY(name) references Information(name) ON DELETE CASCADE ON UPDATE CASCADE
);

create view priceNcaution AS
select information.name, information.price, caution.content
From information, caution
where information.name = caution.name;

insert into FirstCategory (first) values ("음료");
insert into FirstCategory (first) values ("푸드");

insert into SecondCategory (second) values ("콜드 브루");
insert into SecondCategory (second) values ("브루드 커피");
insert into SecondCategory (second) values ("에스프레소");
insert into SecondCategory (second) values ("프라푸치노");
insert into SecondCategory (second) values ("블렌디드");
insert into SecondCategory (second) values ("스타벅스 피지오");
insert into SecondCategory (second) values ("티 (티바나)");
insert into SecondCategory (second) values ("기타 제조 음료");
insert into SecondCategory (second) values ("베이커리");
insert into SecondCategory (second) values ("케이크");
insert into SecondCategory (second) values ("샌드위치 & 샐러드");
insert into SecondCategory (second) values ("따뜻한 푸드");
insert into SecondCategory (second) values ("과일 & 요거트");
insert into SecondCategory (second) values ("스낵 & 미니 디저트");
insert into SecondCategory (second) values ("아이스크림");

insert into Information (name, price, firstCategoryIdx, secondCategoryIdx) values ("자바 칩 프라푸치노", 6100, 1, 4);
insert into Information (name, price, firstCategoryIdx, secondCategoryIdx) values ("제주 청보리 크림 프라푸치노", 7500, 1, 4);
insert into Information (name, price, firstCategoryIdx, secondCategoryIdx) values ("아이스 라임 패션 티", 5600, 1, 7);
insert into Information (name, price, firstCategoryIdx, secondCategoryIdx) values ("애플망고 요거트 블렌디드", 6300, 1, 5);
insert into Information (name, price, firstCategoryIdx, secondCategoryIdx) values ("부드러운 생크림 카스테라", 4500, 2, 10);
insert into Information (name, price, firstCategoryIdx, secondCategoryIdx) values ("블루베리 베이글", 2800, 2, 9);
insert into Information (name, price, firstCategoryIdx, secondCategoryIdx) values ("스모크드 소시지 브레드", 4500, 2, 9);
insert into Information (name, price, firstCategoryIdx, secondCategoryIdx) values ("로스트 치킨 샐러드 밀 박스", 6500, 2, 11);
insert into Information (name, price, firstCategoryIdx, secondCategoryIdx) values ("멕시칸 브리또 밀 박스", 5900, 2, 11);

insert into Caution (name, content) values ("제주 청보리 크림 프라푸치노", "제주 지역에서만 판매");
insert into Caution (name, content) values ("애플망고 요거트 블렌디드", "여름 한정 시즌 상품");
insert into Caution (name, content) values ("자바 칩 프라푸치노", "프리퀀시 적립 불가");
insert into Caution (name, content) values ("스모크드 소시지 브레드", "오전에만 주문 가능");

insert into PersonalOption (name, content) values ("자바 칩 프라푸치노", "에스프레소 휘핑으로 변경하면 꿀맛!");
insert into PersonalOption (name, content) values ("스모크드 소시지 브레드", "꼭 데워달라고 요청하기");