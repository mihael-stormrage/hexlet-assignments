@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@template.layout.page(
    content = @`
        <main class="container">
            <legend>Создать статью</legend>
            @if(page.getErrors() != null)
                <div>
                    @for(var validator: page.getErrors().values())
                        @for(var e: validator)
                            <div class="alert alert-danger w-75">
                                ${e.getMessage()}
                            </div>
                        @endfor
                    @endfor
                </div>
            @endif
            <form action="/articles" method="POST">
                <div class="mb-3">
                    <label class="form-label">Название</label>
                    <input type="text"
                           name="title"
                           class="form-control w-75"
                           value="${page.getTitle()}" />
                </div>
                <div class="mb-3">
                    <label class="form-label">Содержимое</label>
                    <textarea name="content"
                              class="form-control w-75"
                    >${page.getContent()}</textarea>
                </div>
                <input type="submit" class="btn btn-primary" value="Опубликовать" />
            </form>
        </main>
    `
)
