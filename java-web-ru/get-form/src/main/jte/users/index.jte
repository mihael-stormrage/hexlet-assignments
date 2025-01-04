@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
        <div class="container">
            <form method="get">
                <div class="input-group mb-3">
                    <input type="search"
                           class="form-control"
                           placeholder="First name"
                           aria-label="Search field"
                           name="term"
                           value="${page.getTerm()}">
                    <input type="submit" class="btn btn-primary" value="Search" />
                </div>
            </form>
            @if(!page.getUsers().isEmpty())
                <div class="list-group container">
                    @for(var u: page.getUsers())
                        <a href="/users/${u.getId()}"
                           class="list-group-item list-group-item-action">
                            ${u.getFirstName()} ${u.getLastName()}
                        </a>
                    @endfor
                </div>
            @endif
        </div>
    `
)
