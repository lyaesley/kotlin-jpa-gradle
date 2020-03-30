
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>

    <script>
    window.addEventListener('DOMContentLoaded', (event) => {
        console.log(event);
        window.vue =
        new Vue({
            el: '#app',
            data: {
                title: '${title}',
                body: '${body}',
                info: null,
                loading: true,
                errored: false
            },
            methods: {
                getHtmlTxt: function() {
                    axios
                         .get('http://localhost:8080/getHtml')
                        // .get('https://api.coindesk.com/v1/bpi/currentprice.json')
                        .then(response => {
                            this.info = response.data
                        })
                        .catch(error => {
                            console.log(error)
                            this.errored = true
                        })
                        .finally(() => this.loading = false)
                }
            }
        })
    });



    </script>
    <title>Title</title>
</head>
<body>
    <div id="app">
        {{title}}
        {{body}}

        <input type="button" value="html 가져와" v-on:click="getHtmlTxt()"/>
        <span v-html="info"></span>
    </div>




</body>
</html>
