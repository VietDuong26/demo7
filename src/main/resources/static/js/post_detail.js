document.addEventListener("DOMContentLoaded", () => {
    document.getElementById('date').innerHTML = new Date().toString();
});

function sendComment(postId, userId, content) {
    let url = "http://localhost:8080/addNewComment?postId=" + postId + "&userId=" + userId + "&content=" + content;
    $.ajax({
        type: "POST",
        url: url,
        success: function (data) {
        },
        error: function (error) {
            console.log(error)
        }
    });
}

function getCommentData(id) {
    let url = "http://localhost:8080/getAllCommentByPost?postId=" + id;
    $.ajax({
        type: "GET",
        dataType: 'json',
        url: url,
        success: function (data) {
            console.log(data);
            loadComment(data);
        },
        error: function (error) {
            console.log(error)
        }
    });
}

function loadComment(data) {
    let comments=``;
    document.getElementById('list_comment').innerHTML=comments;
    for (let i = 0; i < data.length; i++) {
        let x=data[i];
        debugger;
        comments+=`
            <div style="display: flex;min-height: 50px;max-height: 400px;gap:20px;">
                    <div style="width: 8%;display: flex;justify-content: center;">
                        <div
                                style="width: 50px;height: 50px;background-image: url(/image/logo-24h-new.svg);background-size: 100% 100%;border-radius: 50%;">
                        </div>
                    </div>
                    <div>
                        <div>
                            <a style="font-weight: bold;text-decoration: none;color:black" href="">
                            `+x.user.username+`
                            </a>
                            <p>
                            `+x.content+`
                            </p>
                        </div>
                        <div class="like" style="display:flex;gap:20px;margin-top: 10px;">
                            <div style="cursor: pointer;color:blue"><i class="fas fa-thumbs-up"
                                                                       style="transition:.3s ease"></i> <i>Thích
                                (26)</i>
                            </div>
                            <div style="cursor: pointer;">Trả lời</div>
                            <div style="width: 300px;height: 30px;">
                                    <textarea type="text" style="width: 90%;height: 60%;"
                                              placeholder="Chia sẻ ý kiến của bạn" maxlength="500"></textarea>
                            </div>
                        </div>
                        <div id="list-reply"
                             style="border-left:2px solid grey;margin-top: 20px;margin-left: 20px;display: flex;flex-wrap: wrap;row-gap: 10px;overflow-y: scroll;max-height: 300px;">`;
        for (let j = 0; j < x.listReply.length; j++) {
            comments+=`<div style="width: 80%;">
                                <a style="font-weight: bold;text-decoration: none;color:black" href="">
                                </a>
                                <p>
                                    <span><a style="text-decoration: none;color:black" href=""></a></span>
                                    kiểm soát
                                    vàng miếng thì vàng nhẫn
                                    nhảy đùng đùng ) thua. Vốn cứ găm
                                    hết vào vàng với bđs thế này thì nền kinh tế còn dậm chân dài dài
                                </p>
                            </div>`;
        }
        comments+=`</div>`;
        comments+=`            
                        </div>
                    </div>
                    `;
    }
    document.getElementById('list_comment').innerHTML=comments;
}