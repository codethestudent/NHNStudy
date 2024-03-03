-- 기존 테이블 삭제
drop table if exists birth_death_report_resident;
drop table if exists family_relationship;
drop table if exists household_movement_address;
drop table if exists household_composition_resident;
drop table if exists certificate_issue;
drop table if exists household;
drop table if exists resident;


-- 테이블 생성
create table resident
(
    resident_serial_number       int          not null auto_increment,
    name                         varchar(100) not null,
    resident_registration_number varchar(300) not null,
    gender_code                  varchar(20)  not null,
    birth_date                   datetime     not null,
    birth_place_code             varchar(20)  not null,
    registration_base_address    varchar(500) not null,
    death_date                   datetime     null,
    death_place_code             varchar(20)  null,
    death_place_address          varchar(500) null,
    id                           varchar(20)  null,
    password                     varchar(100) null,
    email                        varchar(300) null,
    primary key (resident_serial_number)
);

create table birth_death_report_resident
(
    resident_serial_number           int         not null,
    birth_death_type_code            varchar(20) not null,
    report_resident_serial_number    int         not null,
    birth_death_report_date          date        not null,
    birth_report_qualifications_code varchar(20) null,
    death_report_qualifications_code varchar(20) null,
    email_address                    varchar(50) null,
    phone_number                     varchar(20) not null,
    primary key (resident_serial_number, birth_death_type_code)
);

create table family_relationship
(
    base_resident_serial_number   int         not null,
    family_resident_serial_number int         not null,
    family_relationship_code      varchar(20) not null,
    primary key (base_resident_serial_number, family_resident_serial_number)
);

create table household
(
    household_serial_number           int          not null auto_increment,
    household_resident_serial_number  int          not null,
    household_composition_date        date         not null,
    household_composition_reason_code varchar(20)  not null,
    current_house_movement_address    varchar(500) not null,
    primary key (household_serial_number)
);

create table household_movement_address
(
    household_serial_number    int                    not null,
    house_movement_report_date date                   not null,
    house_movement_address     varchar(500)           not null,
    last_address_yn            varchar(1) default 'Y' not null,
    primary key (household_serial_number, house_movement_report_date)
);

create table household_composition_resident
(
    household_serial_number                  int         not null,
    resident_serial_number                   int         not null,
    report_date                              date        not null,
    household_relationship_code              varchar(20) not null,
    household_composition_change_reason_code varchar(20) not null,
    primary key (household_serial_number, resident_serial_number)
);

create table certificate_issue
(
    certificate_confirmation_number bigint      not null,
    resident_serial_number          int         not null,
    certificate_type_code           varchar(20) not null,
    certificate_issue_date          date        not null,
    primary key (certificate_confirmation_number)
);


-- resident 테이블 데이터 추가
insert into resident
values (1, '남길동', '130914-*******', '남', '19130914072200', '자택', '경기도 성남시 분당구 대왕판교로645번길', '20210429090300', '주택',
        '강원도 고성군 금강산로 290번길', 'asdf', 'asdf', 'asdf@gmail.com');
insert into resident
values (2, '남석환', '540514-*******', '남', '19540514173000', '병원', '경기도 성남시 분당구 대왕판교로645번길', null, null, null, 'asdff',
        'asdf',
        'asdff@gmail.com');
insert into resident
values (3, '박한나', '551022-*******', '여', '19551022111500', '병원', '서울특별시 중구 세종대로 110번길', null, null, null, 'asddf',
        'asdf',
        'asddf@gmail.com');
insert into resident
values (4, '남기준', '790510-*******', '남', '19790510204500', '병원', '경기도 성남시 분당구 대왕판교로645번길', null, null, null,
        'codethestudent',
        'asdf',
        'hjun303@gnu.ac.kr');
insert into resident
values (5, '이주은', '820821-*******', '여', '19820821012800', '병원', '경기도 수원시 팔달구 효원로 1번길', null, null, null, 'aasdf',
        'asdf',
        'aasdf@gmail.com');
insert into resident
values (6, '이선미', '851205-*******', '여', '19851205220100', '병원', '경기도 수원시 팔달구 효원로 1번길', null, null, null, 'asdfasdf',
        'asdf',
        'asdfasdf@gmail.com');
insert into resident
values (7, '남기석', '120315-*******', '남', '20120315145900', '병원', '경기도 성남시 분당구 대왕판교로645번길', null, null, null,
        'asdfasdff', 'asdf',
        'asdfasdff@gmail.com');
--
commit;
--
--
--  birth_death_report_resident 테이블 데이터 추가
insert into birth_death_report_resident
values (7, '출생', 4, '20120317', '부', null, 'nam@nhnad.co.kr', '010-1234-5678');
insert into birth_death_report_resident
values (1, '사망', 2, '20200502', '비동거친족', null, null, '010-2345-6789');

commit;
--
--
-- family_relationship 테이블 데이터 추가
insert into family_relationship
values (1, 2, '자녀');
insert into family_relationship
values (2, 1, '부');
insert into family_relationship
values (2, 3, '배우자');
insert into family_relationship
values (2, 4, '자녀');
insert into family_relationship
values (3, 2, '배우자');
insert into family_relationship
values (3, 4, '자녀');
insert into family_relationship
values (4, 2, '부');
insert into family_relationship
values (4, 3, '모');
insert into family_relationship
values (4, 5, '배우자');
insert into family_relationship
values (4, 7, '자녀');
insert into family_relationship
values (5, 4, '배우자');
insert into family_relationship
values (5, 7, '자녀');
insert into family_relationship
values (7, 4, '부');
insert into family_relationship
values (7, 5, '모');
--
commit;
--
--
-- household 테이블 데이터 추가
insert into household
values (1, 4, '20091002', '세대분리', '경기도 성남시 분당구 대왕판교로 645번길');

commit;
--
--
-- household_movement_address 테이블 데이터 추가
insert into household_movement_address
values (1, '20071031', '서울시 동작구 상도로 940번길', 'N');
insert into household_movement_address
values (1, '20091031', '경기도 성남시 분당구 불정로 90번길', 'N');
insert into household_movement_address
values (1, '20130305', '경기도 성남시 분당구 대왕판교로 645번길', 'Y');

commit;
--
--
-- household_composition_resident 테이블 데이터 추가
insert into household_composition_resident
values (1, 4, '20091002', '본인', '세대분리');
insert into household_composition_resident
values (1, 5, '20100215', '배우자', '전입');
insert into household_composition_resident
values (1, 7, '20120317', '자녀', '출생등록');
insert into household_composition_resident
values (1, 6, '20151129', '동거인', '전입');

commit;
--
--
-- certificate_issue 테이블 데이터 추가
insert into certificate_issue
values (1234567891011121, 4, '가족관계증명서', '20211025');
insert into certificate_issue
values (9876543210987654, 4, '주민등록등본', '20211025');

commit;


-- -- 가족관계증명서 조회SQL
-- select B.certificate_type_code
--      , concat(substr(B.certificate_confirmation_number, 1, 8), '-', substr(B.certificate_confirmation_number, 9, 8))
--      , A.registration_base_address
-- from resident A
--          inner join certificate_issue B
--                     on B.resident_serial_number = A.resident_serial_number
--                         and B.certificate_type_code  = '가족관계증명서'
-- where A.resident_serial_number = 4;
--
--
-- select '본인'
--      , name
--      , date_format(birth_date, '%Y년 %m월 %d일')
--      , gender_code
-- from resident
-- where resident_serial_number = 4
-- union all
-- select A.family_relationship_code
--      , B.name
--      , date_format(B.birth_date, '%Y년 %m월 %d일')
--      , B.gender_code
-- from family_relationship A
--          inner join resident B
--                     on B.resident_serial_number = A.family_resident_serial_number
-- where A.base_resident_serial_number = 4;
--

-- -- 11. 주민등록등본 조회SQL
-- select A.certificate_type_code
--      , concat(substr(A.certificate_confirmation_number, 1, 8), '-', substr(A.certificate_confirmation_number, 9, 8))
--      , D.name
--      , C.household_composition_reason_code
--      , C.household_composition_date
-- from certificate_issue A
--          inner join household_composition_resident B
--                     on B.resident_serial_number = A.resident_serial_number
--          inner join household C
--                     on C.household_serial_number = B.household_serial_number
--          inner join resident D
--                     on D.resident_serial_number = C.household_resident_serial_number
-- where A.resident_serial_number = 4
--   and A.certificate_type_code  = '주민등록등본';
--
--
-- select case when C.last_address_yn = 'Y' then '현주소' else '前주소' end
--      , C.house_movement_report_date
--      , C.house_movement_address
-- from household_composition_resident A
--          inner join household B
--                     on B.household_serial_number = A.household_serial_number
--          inner join household_movement_address C
--                     on C.household_serial_number = B.household_serial_number
-- where A.resident_serial_number = 4
-- order by C.house_movement_report_date desc;
--
--
-- select A.household_relationship_code
--      , B.name
--      , B.resident_registration_number
--      , A.report_date
--      , A.household_composition_change_reason_code
-- from household_composition_resident A
--          inner join resident B
--                     on B.resident_serial_number = A.resident_serial_number
-- where household_serial_number = (
--     select household_serial_number
--     from household_composition_resident
--     where resident_serial_number = 4
-- )
-- order by A.report_date;