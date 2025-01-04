@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
    content = @`
        <main class="container">
            <h1>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h1>
            <a href="mailto:${page.getUser().getEmail()}"
               class="badge rounded-pill bg-info fs-6">
                ${page.getUser().getEmail()}
            </a>
        </main>
    `
)
