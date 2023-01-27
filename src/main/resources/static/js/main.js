        $("#logout").on("click", function(){
             $.ajax({
                      type : "POST",
                      url : "/boards/logout.do",
                      success : function(res) {
                        window.location.href = '/boards/index.do';
                      },
                      error : function(request, status, error) {
                          alert("code:" + request.status + "\n" + "error:" + error);
                      }
                  })
        })

        const loremIpsum = $("#lorem-ipsum")
        fetch()
            .then(response => response.text())
            .then(result => loremIpsum.innerHTML = result)

            const modal = document.getElementById("modal")
            const btnModal = document.getElementById("btn-modal")
            btnModal.addEventListener("click", e => {
                modal.style.display = "flex"
            })

            const closeBtn = modal.querySelector(".close-area")
            closeBtn.addEventListener("click", e => {
                modal.style.display = "none"
            })

      displayCurrentTime()
      function displayCurrentTime() {
        const weekDesc = ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'];
        const date = new Date();
        const year = date.getYear() + 1900;
        const month = date.getMonth() + 1;
        const day = date.getDate();
        const week = date.getDay();
        const hours = date.getHours();
        const minutes = date.getMinutes();
        const seconds = date.getSeconds();

        const currDt = `${year}년 ${month}월 ${day}일 ${weekDesc[week]} ${hours < 10 ? `0${hours}` : hours}:${minutes < 10 ? `0${minutes}`  : minutes }:${seconds < 10 ? `0${seconds }`  : seconds }`;

        $(".clock").html(currDt)

        setTimeout(function(){
          displayCurrentTime()
        },1000)
      }

