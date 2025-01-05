@import gg.jte.Content
@import exercise.dto.BasePage
@param Content content
@param BasePage page = null

<!-- BEGIN -->
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
              crossorigin="anonymous">
        <title>Hello Hexlet!</title>
    </head>
    <body>
        <div class="container">
            @if(page != null && page.getFlashType() != null)
                <div class="mx-auto px-4 pt-4">
                    <div class="alert alert-${page.getFlashType()} w-75">
                        ${page.getFlash()}
                    </div>
                </div>
            @endif
            ${content}
        </div>
    </body>
</html>
<!-- END -->
