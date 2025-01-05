@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostPage
@param PostPage page

@template.layout.page(
    content = @`
        <div class="container">
            <article>
                <h1>${page.getPost().getName()}</h1>
                <div class="container mt-3">
                    ${page.getPost().getBody()}
                </div>
            </article>
            <nav class="navbar">
                <a href="${NamedRoutes.postsPath()}"
                   class="btn btn-primary mt-3">
                    Назад
                </a>
            </nav>
        </div>
    `
)
