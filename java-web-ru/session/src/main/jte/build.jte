@import exercise.util.NamedRoutes
@import exercise.dto.LoginPage
@param LoginPage page

@template.layout.page(
    content = @`
        <main class="container">
            <div class="mx-auto p-4 py-md-5">
                @if(page.getError() != null)
                    <div class="alert alert-danger">
                        ${page.getError()}
                    </div>
                @endif
                <form action="${NamedRoutes.loginPath()}" method="post">
                    <div class="mb-3">
                        <label class="form-label">
                            Логин
                            <input type="text"
                                   class="form-control"
                                   name="name"
                                   value="${page.getName()}"
                                   required />
                        </label>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">
                            Пароль
                            <input type="password"
                                   class="form-control"
                                   name="password"
                                   required />
                        </label>
                    </div>
                    <input type="submit"
                           class="btn btn-primary"
                           value="Войти"/>
                </form>
            </div>
        </main>
    `
)
