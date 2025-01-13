# 쿠팡 클론 코딩 프로젝트

## 프로젝트 개요
- **프로젝트명**: 쿠팡 클론 코딩
- **개발 언어**: Java
- **목표**: 로그인 기능 없이 물건을 추가하고 장바구니에 담고 구매 및 리뷰를 작성하는 간단한 전자상거래 웹서비스를 구현합니다.
- **프레임워크**: Spring

## 주요 기능

### 1. 상품 관리 기능
#### 1.1 상품 추가
- 사용자는 새로운 상품을 추가할 수 있습니다.
- **필요한 정보**: 상품명, 가격, 재고수량, 상품 설명 등.

#### 1.2 상품 조회
- 사용자는 전체 상품 목록을 조회하거나 특정 상품을 검색할 수 있습니다.
- **상세 조회** 시, 해당 상품의 모든 정보가 표시됩니다.

#### 1.3 상품 수정
- 사용자는 상품의 정보를 수정할 수 있습니다.
- **수정 가능 항목**: 상품명, 가격, 재고수량, 상품 설명 등.

#### 1.4 상품 삭제
- 사용자는 특정 상품을 삭제할 수 있습니다.
- 삭제된 상품은 더 이상 조회되지 않습니다.

## 시스템 구조
- **구조**:
    - **Controller**: 사용자 요청을 처리하고, 서비스를 통해 필요한 작업을 수행
    - **Service**: 비즈니스 로직을 처리
    - **Repository**: 데이터베이스와 상호작용
    - **Product**: 상품 정보를 저장하는 데이터 모델

## 개발 도구 및 환경
- **IDE**: IntelliJ IDEA
- **빌드 도구**: Maven
- **Java 버전**: Java 8
- **프레임워크**: Spring
- **데이터베이스**: mySQL or mariaDB
- **프론트 엔드**: Thymeleaf

## 데이터 모델
- **Product**: 상품 정보를 저장하는 테이블
    - **id**: 상품 ID
    - **name**: 상품명
    - **price**: 가격
    - **stock**: 재고 수량
    - **description**: 상품 설명
    - **image**: 상품 이미지 파일 이름
    - **createdAt**: 생성일
    - **updatedAt**: 수정일

## 실행 방법
1. **데이터베이스 설정**
    - `src/main/webapp/WEB-INF/applicationContext.xml` 파일을 추가한 후, 데이터베이스 연결 정보를 입력합니다.
    - `spring.datasource.url`, `spring.datasource.username`, `spring.datasource.password`를 수정합니다.
```properties
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:jdbc="http://www.springframework.org/schema/jdbc"
       xsi:schemaLocation="
           http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/context
           http://www.springframework.org/schema/context/spring-context.xsd
           http://www.springframework.org/schema/jdbc
           http://www.springframework.org/schema/jdbc/spring-jdbc.xsd">

    <context:annotation-config/>
    <context:component-scan base-package="com.example"/>

    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="com.mysql.cj.jdbc.Driver"/>
        <property name="url" value="url"/>
        <property name="username" value="username"/>
        <property name="password" value="password"/>
    </bean>

    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"></property>
        <property name="configLocation" value="classpath:mybatis-config.xml"></property>
        <property name="mapperLocations" value="classpath:mappers/*-mapper.xml"></property>
    </bean>

    <bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate" destroy-method="clearCache">
        <constructor-arg name="sqlSessionFactory" ref="sqlSessionFactory"/>
    </bean>

</beans>
```# Coupang_Spring_practice
