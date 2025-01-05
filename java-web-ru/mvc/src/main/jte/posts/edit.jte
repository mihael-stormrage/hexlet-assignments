@import exercise.util.NamedRoutes
@import exercise.dto.posts.EditPostPage
@param EditPostPage page

@template.layout.page(
content = @`
    <main class="container">
        <legend class="p-4 py-md-0 mt-3 mb-0">Редактировать пост</legend>
        @if(page.getErrors() != null)
            <div class="p-4 py-md-2">
                @for(var validator: page.getErrors().values())
                    @for(var error: validator)
                        <div class="alert alert-danger w-75">
                            ${error.getMessage()}
                        </div>
                    @endfor
                @endfor
            </div>
        @endif

        <div class="p-4 py-md-0">
            <form action="${NamedRoutes.postPath(page.getPost().getId())}" method="post">
                <div class="mb-3">
                    <label class="form-label">Название</label>
                    <input type="text"
                           class="form-control w-75"
                           name="name"
                           value="${page.getPost().getName()}"/>
                </div>
                <div class="mb-3">
                    <label class="form-label">Содержание</label>
                    <textarea class="form-control w-75"
                              rows="20"
                              cols="70"
                              name="body"
                    >${page.getPost().getBody()}</textarea>
                </div>
                <input type="submit" class="btn btn-primary" value="Сохранить"/>
            </form>
        </div>
    </main>
`
)
