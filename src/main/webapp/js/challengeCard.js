		$(function() {
			// 옵션추가 버튼 클릭시
			$("#addItemBtn").click(
					function() {
						// item 의 최대번호 구하기
						var lastItemNo = $("#contentTable tr:last").attr("class")
								.replace("item", "");

						var newitem = $("#contentTable tr:eq(1)").clone();
						newitem.removeClass();
						newitem.find("td:eq(0)").attr("rowspan", "1");
						newitem.addClass("item" + (parseInt(lastItemNo) + 1));

						$("#contentTable").append(newitem);
					});//click

			// 항목추가 버튼 클릭시
			$(".addBtn").on("click", function() {
				var clickedRow = $(this).parent().parent();
				var cls = clickedRow.attr("class");

				// tr 복사해서 마지막에 추가
				var newrow = clickedRow.clone();
				newrow.find("td:eq(0)").remove();
				newrow.insertAfter($("#contentTable ." + cls + ":last"));

				// rowspan 조정
				resizeRowspan(cls);
			});//click

			// 삭제버튼 클릭시
			$(".delBtn").on("click", function() {
				var clickedRow = $(this).parent().parent();
				var cls = clickedRow.attr("class");

				// 각 항목의 첫번째 row를 삭제한 경우 다음 row에 td 하나를 추가해 준다.
				if (clickedRow.find("td:eq(0)").attr("rowspan")) {
					if (clickedRow.next().hasClass(cls)) {
						clickedRow.next().prepend(clickedRow.find("td:eq(0)"));
					}
				}//if

				clickedRow.remove();

				// rowspan 조정
				resizeRowspan(cls);
			});//click

			// cls : rowspan 을 조정할 class ex) item1, item2, ...
			function resizeRowspan(cls) {
				var rowspan = $("." + cls).length;
				$("." + cls + ":first td:eq(0)").attr("rowspan", rowspan);
			}//resizeRowspan
		});
