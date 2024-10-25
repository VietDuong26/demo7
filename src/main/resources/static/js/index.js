let count = 0;

function getMorePost() {
    count++;
    let url = "http://localhost:8080/getMorePost?page=" + count;
    $.ajax({
        type: "GET",
        dataType: "json",
        url: url,
        success: function (data) {
            loadMorePost(data);
        },
        error: function (error) {
            console.log(error)
        }
    });
}

function loadMorePost(data) {
    var div = document.createElement('div');
    let content = ``;
    for (let i = 0; i < data.length; i++) {
        content += `
<a href="/post_detail?id=` + data[i].id + `" style="text-decoration: none;color: black;">
        <div style="height:280px;width: 100%;display:flex;gap:20px;cursor:pointer;">
                <div
                        style="width:30%;height: 100%;background-image: url(/image/logo-24h-new.svg);background-size: 100% 100%;">
                </div>
                <div style="width:65%;max-height: 80%;">
                    <p id="title" style="font-size:30px;">` + data[i].titile
            + `</p>
                    <div id="content"
                         style="color:rgba(128, 128, 128, 0.756);display: -webkit-box;max-width: 100%;-webkit-line-clamp: 6;-webkit-box-orient: vertical;overflow: hidden;text-overflow: ellipsis;">
                        ` + data[i].content + `
                        </div>
                </div>
            </div>
        `
    }
    div.innerHTML = content;
    document.getElementById("post_list").appendChild(div);
}