<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/resources/common/adminHeader.jsp"></jsp:include>
<jsp:include page="/resources/common/adminNavOpen.jsp"></jsp:include>
<!-- 이곳이 body -->
<hr class="my-4">
<h1 class="page_title color5">도서 대출</h1>
<hr class="my-4">
<c:choose>
    <c:when test="${possible}">
        <div style="width: 500px; overflow: hidden">
        <div class="div_color5 width_400" style="float: left">
      <p>  ${member.name}은 ${member.availAmount}만큼 대여 가능합니다.</p>
            <p id="countt"></p>
        </div>
        <form style="float: left" method="post" id="booksub">
            <input type="hidden" name="member.member_id" value="${member.member_id}">
            <button type="submit" id="submitbtn" class="color3_btn custom_btn" disabled="disabled" STYLE="width: 80px; height: 67px" > <i class="fas fa-clipboard-check"></i> </button>
        </form>
        </div>

            <p id="bookname"></p>
        <input type="text" id="booksearch" class="inputtext width_400" onkeyup="test1()">
        <table class="jc_table width_970">
            <tr>
                <th class="width_160">
                    북코드
                </th>
                <th class="width_670">
                    책이름
                </th>
                <th class="width_160 td_middle">대여 선택</th>
            </tr>
            <tbody id="selectbook">

            </tbody>
        </table>
        <script>
            var a = false;
            var amount = ${member.availAmount};
            var count = 0;

            console.log(amount);

            function test1() {
                if (!a) {
                    a = true;
                    $('#selectbook').text("");
                    $.ajax({
                        url: '${pageContext.request.contextPath}/admin/borrow/bookSearch?bookname=' + $('#booksearch').val(),
                        type: 'get',
                        datatype: 'json',
                        success: function (data) {
                            $(data).each(function (key, value) {
                                console.log(value);
                                var text = '<td class="td_middle">대출중</td></tr>';
                                var idcode = value.book_code;
                                var a = $('.booklist');
                                if (value.book_exist == 1) {
                                    text = '<td class="td_middle"><button class="btn" onclick="submitt(this)" name="' + value.book_name + '" value="' + idcode + '">선택</button></td> </tr>'
                                    $.each(a, function (index, item) {
                                        if (item.value == value.book_code) {
                                            text = '<td class="td_middle"><button class="btn" onclick="submitt(this)" value="' + idcode + '" disabled>선택됨</button></td> </tr>'
                                        }
                                    });
                                }
                                $('#selectbook').append('<tr> <td>'
                                    + value.book_code + '</td> <td>'
                                    + value.book_name + '</td>' + text
                                );

                            });
                            a = false;
                        },
                        error: function () {
                            alert(error);
                        }
                    });
                }
            }

            function submitt(obj) {
                console.log(obj);
                if (count < amount) {
                    $('#submitbtn').attr("disabled",false);
                    $('#countt').text("");
                    $('#booksub').append(
                        '<input type="hidden" class="booklist" name="booklist[' + count + ']" value="' + obj.value + '" readonly >');
                    count++;
                    $('#bookname').append(obj.name+'<br>');
                    $('#countt').append('현재 ' + count + '권 등록했습니다.');
                    $('#selectbook').text("");
                }
            }
        </script>
    </c:when>
    <c:otherwise>
        <div class="div_color5 width_400">
        ${member.name}은 현재 대여 불가 상태입니다.<br/>
        <c:if test="${member.availAmount==0}">
          <p> 대여가능 권수가 0권이므로 대여가 불가합니다.</p>
        </c:if>
        <c:if test="${member.possibledate ne 'POSSIBLE'}">
          <p> 연체 패널티로 인해 ${member.possibledate}까지 대여 불가합니다!</p>
        </c:if>
        </div>
    </c:otherwise>

</c:choose>

<jsp:include page="/resources/common/adminNavClose.jsp"></jsp:include>
<jsp:include page="/resources/common/adminFooter.jsp"></jsp:include>

