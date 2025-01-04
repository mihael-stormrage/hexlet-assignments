@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
        <main class="list-group container">
            @for(var u: page.getUsers())
                <a href="/users/${u.getId()}"
                   class="list-group-item list-group-item-action">
                    ${u.getFirstName()} ${u.getLastName()}
                </a>
            @endfor
        </main>
    `
)
