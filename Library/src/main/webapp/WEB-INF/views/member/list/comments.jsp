<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Insert title here</title>
        </head>

        <body>

            <div style="padding-top: 50px" class="media-body text-center text-md-left ml-md-3 ml-0" id="reply">


            </div>
            <c:choose>
                <c:when test="${memberLoginInfo != null}">
                    <form method="post" class="my-5" id="form">
                        <div id="num" class="card-header border-0 font-weight-bold"></div>
                        <!-- Quick Reply -->
                        <div class="form-group mt-4">
                            <label for="replyText">Your comment</label>
                            <textarea name="replytext" class="form-control" id="replyText" rows="5"></textarea>
                            <div class="text-center my-4">
                                <button type="button" class="btn btn-primary" STYLE="width: 120px" onclick="replyInsert(${listInfo.idx})">POST</button>
                            </div>
                        </div>
                        <input type="hidden" name="idx" value="${listInfo.idx}" /> <input type="hidden" name="replyer" value="${memberLoginInfo.name}" />
                        <%-- <input type="hidden" name="r_idx" value="${replyInfo.r_idx}"/> --%>
                            <%-- ${replyInfo} --%>
                    </form>
                </c:when>
                <c:otherwise>
                    <form>
                        <div id="num" class="card-header border-0 font-weight-bold"></div>
                        <!-- Quick Reply -->
                        <div class="form-group mt-4">
                            <label for="replyText">Your comment</label>
                            <textarea onclick="location.href='${pageContext.request.contextPath}/member/memberAccount/login'" placeholder="로그인 후 이용해주세요." readonly="readonly" name="replytext" class="form-control" id="replyText" rows="5"></textarea>
                            <div class="text-center my-4">
                                <button type="button" class="btn btn-primary" STYLE="width: 120px"  onclick="replyInsert(${listInfo.idx})">POST</button>
                            </div>
                        </div>
                        <input type="hidden" name="idx" value="${listInfo.idx}" /> <input type="hidden" name="replyer" value="${memberLoginInfo.name}" />
                        <%-- <input type="hidden" name="r_idx" value="${replyInfo.r_idx}"/> --%>
                            <%-- ${replyInfo} --%>
                    </form>
                </c:otherwise>
            </c:choose>
            <script>
                function replyList(idx) {
                    var reply = '';

                    $.ajax({
                        url: '${pageContext.request.contextPath}/member/home/view/replyList',
                        type: 'GET',
                        data: {
                            "idx": idx
                        },
                        datatype: 'json',
                        success: function(data) {
                            $('#num').html(data.length + ' comments');
                            $(data).each(
                                function(key, value) {
                                    $('#num').html(data.length + ' comments');
                                    reply += '<h5 class="font-weight-bold mt-0">';
                                    reply += '<a href="">' +
                                        value.replyer +
                                        '</a> </h5>';

                                    reply += '<input type="text" readonly style="border: 0px; width:100%; margin-bottom:10px" id=' + key + ' value= "' + value.replytext + '">';
                                    if ('${memberLoginInfo.name}' == value.replyer) {
                                        reply += '<button style="margin-right:10px" type="button" class="btn btn-primary btn-sm"';
                                        reply += 'onclick="replyDelete(' + value.idx + ',' + value.r_idx + ')">삭제</button>';
                                        reply += '<button type="button" class="btn btn-primary btn-sm" onclick="replyUpdate(this, ' + key + ',' + value.idx + ',' + value.r_idx + ')">수정</button>'
                                    }
                                    reply += '<hr />';
                                });
                            $('#reply').html(reply);
                            $('#replyText').val('');
                        },
                        error: function() {
                            alert("리스트 생성 오류ㅠㅠ");
                        }

                    });
                }

                function replyInsert(idx) {
                    var form = $('#form').serialize();
                    $.ajax({
                        url: '${pageContext.request.contextPath}/member/home/view/reply',
                        type: 'POST',
                        data: form,
                        success: function(data) {
                            if (data == 1) {
                                replyList(idx);
                            }
                        },
                        error: function() {
                            alert("쓰기 오류ㅠㅠ");
                        }
                    });
                }

                function replyDelete(idx, r_idx) {
                    $.ajax({
                        url: '${pageContext.request.contextPath}/member/home/view/replyDelete',
                        type: 'GET',
                        data: {
                            "r_idx": r_idx
                        },
                        success: function(data) {
                            if (data == "1") {
                                replyList(idx);
                            }
                        },
                        error: function() {
                            alert("삭제 오류ㅠㅠ");
                        }
                    });
                }

                function replyUpdate(obj, key, idx, r_idx) {
                    /* alert($(obj).html()); */
                    /* obj.innerHTML = "수정하기"; */

                    $(obj).text("수정하기");
                    $('#' + key).attr("readonly", false);
                    $('#' + key).focus();
                    $(obj).removeAttr("onclick");
                    $(obj).attr("onclick", 'replyUpdateAjax(' + idx + ',' + r_idx + ',' + key + ')');

                    /* $(obj).css("background" , "red"); */
                    /* $('#' + key).css("border", "1px solid black"); */
                    /* obj.style. = "red";  */
                    /* console.log(obj.toString()); */
                    /* $('#'+key).after('<button onclick=""> </button>'); */
                    /* console.log($('#'+key).text()); */
                }

                function replyUpdateAjax(idx, r_idx, key) {

                    $.ajax({
                        url: '${pageContext.request.contextPath}/member/home/view/replyUpdate',
                        type: 'POST',
                        data: {
                            "r_idx": r_idx,
                            "val": $('#' + key).val()
                        },
                        success: function(data) {
                            if (data == "1") {
                                replyList(idx);
                            }
                        },
                        error: function() {
                            alert("수정 오류ㅠㅠ");
                        }
                    });
                }

            </script>
        </body>

        </html>
