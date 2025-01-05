@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
    content = @`
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

    <div class="mx-auto p-4 py-md-5">
        <main>
            <h1>Все посты</h1>

            <table class="table table-striped">
                @for(var post : page.getPosts())
                    <tr>
                        <td>
                            <a href="${NamedRoutes.postPath(post.getId())}">
                                ${post.getName()}
                            </a>
                        </td>
                    </tr>
                @endfor
            </table>

            <nav class="navbar bg-body-tertiary container-fluid justify-content-start">
                <a href="${NamedRoutes.postsPath()}?page=${page.getPageNumber() - 1}"
                   class="btn btn-sm me-2 i bi-arrow-left-short
                          @if(page.hasPrev()) btn-outline-info
                          @else disabled btn-outline-secondary @endif"></a>
                <a href="${NamedRoutes.postsPath()}?page=${page.getPageNumber() + 1}"
                   class="btn btn-sm me-2 i bi-arrow-right-short
                          @if(page.hasNext()) btn-outline-info
                          @else disabled btn-outline-secondary @endif"></a>
            </nav>
        </main>
    </div>
    `
)
