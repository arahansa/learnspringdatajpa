<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>아라한사의 jpa정리</title>
<style>
	li{ padding: 5px;}
	span { color: green; display:block;}
	span.tag { color: blue;}
	input { margin-top : 10px;, margin-bottom: 10px;}
	div.description{ background: #e0e0e0; padding: 10px;}
</style>
</head>
<body>

<c:if test="${not empty data }">
<div>
<h3>받은 데이터</h3>
${data }
</div>
</c:if>
<br>
<a href="/">홈</a>
<br>
<h3>관계매핑</h3>
<ul>
	<li>
		단일 매핑해본 것 <a href="/one">/one</a>  =  영속성 컨텍스트로 인해 마지막 JustOne은 값을 캐싱하고 있다. 
		<br>고로 이것을 누를 수록 마지막에의 저스트원 값만 다른 것을 볼 수가 있을 것이다.<br> 
		<span>패키지 이름 : com.example.r_mapping.justone</span>
	</li>
	<li>
		일대일매핑 <a href="/onetoone">/onetoone</a>  =  멤버와 멤버 세부사항이 일대일로 묶여있다. 
		<span>패키지 이름 : com.example.r_mapping.onetoone</span>
	</li> 
	<li>
		일대다매핑 <a href="/onetomany">/onetomany</a>  =  대학 하나에 묶인 학생들을 가져온다.
		<span>패키지 이름 : com.example.r_mapping.onetomany</span>
	</li>
	<li>
		다대다매핑 <a href="/manytomany">/manytomany</a>  =  다대다매핑이다. 카테고리 하나에 대해서 책을 가져옵니다.
		<span>패키지 이름 : com.example.r_mapping.manytomany </span>
	</li>
	
</ul>
<h3>Spring Data Jpa, Query DSL 를 이용한 검색 </h3>
<div class="description">
잠시 설명 : 
게시글(BoardArticle), 사용자(User), 댓글(Comment), 태그(Tags) 를 가지고 있다고 가정해보자.<br>
게시글과 사용자는 일대일 매핑을 하고 있으며 , 게시글과 댓글은 일대다, 태그와 게시글은 다대다 관계를 가진다. <br>
사용자와 댓글또한 일대일 관계를 가진다. 여기에 무작위로 데이터를 넣어보고 조건에 따라 가져와보겠다!!
</div> 
<ul>
	<li>
		spring data jpa 기본 : 
		<form action="/commonBoard" method="post">
			사용자 정보: <input type="text" name="nick" placeholder="닉네임">
			<input type="text" name="age" placeholder="나이">
			<br>
			<input type="text" name="title" placeholder="제목">
			<input type="text" name="content" placeholder="내용">
			<input type="submit" value="전송">
		</form>
		<span class="tag">레퍼런스 : http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation</span>
		<span class="tag">슬립(하단에도 검색 나옴^^) : http://slipp.net/wiki/pages/viewpage.action?pageId=24641728</span>
	</li>
	<li>springdatajpa- specification</li>
	<li>query dsl</li>
	
</ul>

<h3>다른 매핑</h3>
<ul>
	<li>
		세컨더리테이블 <a href="/secondary">/secondary</a>  =  필드를 바깥 테이블로 빼낼 수 있다.
		<span>패키지 이름 : com.example.mapping.secondary</span> 
	</li>
	<li>
		@MappedSuperclass <a href="/mappedSuperclass">/mappedSuperclass</a>  =  상속을 하면서 부모클래스의 필드를 모두 가져온다.
		<span>패키지 이름 : com.example.mapping.mappedsuperclass</span>
		<span class="tag">@PrePersist, @PreUpdate 어노테이션을 BasicEntity에 포함.(petri님 소스 참고)</span> 
	</li>
	<li>
		상속매핑(단일테이블) : <a href="/inheritanceSingle">/inheritanceSingle</a> = 각각의 상속을 단일테이블로 묶는다
		 <span>패키지 이름 : com.example.mapping.inheritance.singletable</span>
	</li>
	<li>
		상속매핑(클래스당테이블) : <a href="/inheritancePerClass">/inheritancePerClass</a> = 상속한 클래스마다 테이블을 만든다.
		<span>패키지 이름 : com.example.mapping.inheritance.perclass</span>
	</li>
	<li>
		상속매핑(조인) : <a href="/inheritanceJoin">/inheritanceJoin</a> = 공통부분을 분리시키고 조인으로 가져온다. 
		<span>패키지 이름 : com.example.mapping.inheritance.join</span>
		참고할만한 링크 : http://www.javaroots.com/2013/07/hibernate-inheritance-joined-strategy.html
	</li>
	
	<li>
		컴파운드키 : <a href="compoundkey">/compoundkey</a> = 변수를 조합해서 하나의 키로 써본다.
		<span>패키지 이름 : com.example.mapping.compoundkey</span>
		여기서 이름, 성, 사는 도시 세개 합친 세트([이름,성,도시]) 중에 하나라도 겹치면 데이터가 안 들어간다.
		<span class="tag">비슷한 기능으로 @UniqueConstrains 어노테이션도 있다</span> 
		<form action="/compoundkey" method="post">
			<input type="text" name="lastname" placeholder="이름" value="arahansa">
			<input type="text" name="firstname" placeholder="성" value="freddie">
			<input type="text" name="city" placeholder="사는도시" value="jigu">
			<input type="text" name="message" placeholder="메시지" value="msg">
			<input type="submit" value="전송">
		</form>
	</li>
	
	<li>
		Embedded : <a href='/embedded'>/embedded</a> = 다른 엔티티에 내장시킬 수 있다. 
		<span>패키지 이름 : com.example.mapping.embedded</span>
		<span class="tag">@AttributeOverrides 도 같이 나온다. 속성을 오버라이딩해서 재정의 하는 것이다. </span>
	</li>
</ul>

<h3>콜렉션 매핑</h3>
<ul>
	<li></li>
</ul>


<h3> 다른 검색</h3>
<ul>
	<li>JPQL : <a href="/jpql">/jpql</a> = jpql을 이용한 검색</li>
	<li> Criteria : </li>
	<li> NamedQuery : </li>
</ul>

<h3>검증</h3>
<ul>
	<li>
		<%-- <form:form method="post" action="/validation" commandName="dressorder">
			<input type="text" name="name" placeholder="이름" value="arahansa">
			<form:input type="text" path="email" name="email" placeholder="이메일" value="arahansa@naver.com" />
			<form:errors id="error-email" path="email" cssClass="help-block"/>
			<input type="text" name="size" placeholder="당신의 사이즈(숫자)" value="1">
			<input type="text" name="address" placeholder="주소(10글자미만)" value="지구 어느 별">
			<input type="submit" value="전송">
		</form:form> --%>
	</li>
</ul>

<hr>
주의사항과 기타 : 
코드와 매뉴얼로 이야기합니다 by 아라한사
</body>
</html>