<html>
    <head>
        <title>${title}</title>
    </head>
        <body align="center">
        <h1>${title}</h1>

        <table border="1" align="center">
            <tr align="center">
                <td>id</td>
                <td>title</td>
                <td>release_date</td>
                <td>duration</td>
                <td>score</td>
            </tr>
            <#list systems as system>
                <tr>
                    <td>${system.id}</td>
                    <td>${system.title}</td>
                    <td>${system.release_date}</td>
                    <td>${system.duration}</td>
                    <td>${system.score}</td>
                </tr>
            </#list>
        </table>
    </body>
</html>