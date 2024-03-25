$(function(){
    // 수정하기 버튼 클릭 시 이벤트 핸들러
    $("#sanctionBtn").click(function() {
        // 수정된 정보를 가져오기
        var counselingId = ${CounselingDetail.counselingId};
        var counselingJudgment = $("#counselingJudgment").val();
        var counselingDetail = $("#counselingDetail").val();
        var counselingAdopt = $("#counselingAdopt").val();

        // 서버로 전달할 데이터 생성
        var data = {
            counselingId: counselingId,
            counselingJudgment: counselingJudgment,
            counselingDetail: counselingDetail,
            counselingAdopt: counselingAdopt
        };

        // AJAX를 통해 서버로 데이터 전송
        $.ajax({
            type: "POST",
            url: "/counseling/admincounselingUpdate", // 수정 처리를 담당하는 서버의 URL
            data: data,
            success: function(response) {
                // 수정이 성공했을 때의 처리
                alert("수정이 완료되었습니다.");
                // 페이지 새로고침
                location.reload();
            },
            error: function(error) {
                // 수정이 실패했을 때의 처리
                alert("수정에 실패했습니다. 다시 시도해주세요.");
            }
        });
    });
});