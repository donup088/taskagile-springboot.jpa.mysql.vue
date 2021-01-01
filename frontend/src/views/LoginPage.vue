<template>
  <div class="container">
    <div class="row justify-content-center">
      <div class="login-form">
        <Logo/>
        <form @submit.prevent="submitForm">
          <div v-show="errorMessage" class="alert alert-danger failed">{{ errorMessage }}</div>
          <div class="form-group">
            <label for="username">아이디</label>
            <input type="text" class="form-control" id="username" v-model="form.username">
            <div class="field-error" v-if="$v.form.username.$dirty">
              <div class="error" v-if="!$v.form.username.required">아이디를 입력해주세요.</div>
            </div>
          </div>
          <div class="form-group">
            <label for="password">비밀번호</label>
            <input type="password" class="form-control" id="password" v-model="form.password">
            <div class="field-error" v-if="$v.form.password.$dirty">
              <div class="error" v-if="!$v.form.password.required">비밀번호를 입력해주세요</div>
            </div>
          </div>
          <button type="submit" class="btn btn-primary btn-block">로그인</button>
          <p class="sign-up text-muted">회원가입을 안하셨나요? <a href="/register" class="link-sign-up">회원가입</a></p>
          <p><a href="#">비밀번호 찾기</a></p>
        </form>
      </div>
    </div>
    <PageFooter/>
  </div>
</template>

<script>
import { required } from 'vuelidate/src/validators'
import Logo from '@/components/Logo.vue'
import PageFooter from '@/components/PageFooter.vue'
import authenticationService from '@/service/authentication'

export default {
  name: 'LoginPage',
  data: function () {
    return {
      form: {
        username: '',
        password: ''
      },
      errorMessage: ''
    }
  },
  validations: {
    form: {
      username: {
        required
      },
      password: {
        required
      }
    }
  },
  components: {
    Logo,
    PageFooter
  },
  methods: {
    submitForm () {
      this.$v.$touch()
      if (this.$v.$invalid) {
        return
      }
      authenticationService.authenticate(this.form).then(() => {
        this.$router.push({ name: 'home' })
      }).catch((error) => {
        this.errorMessage = error.message
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.container {
  max-width: 1000px;
}

.login-form {
  margin-top: 50px;
  width: 500px;
}

.login-form {
  .form-group label {
    font-weight: bold;
    color: #555;
  }

  .accept-terms {
    margin: 20px 0 40px 0;
  }
}

.sign-up{
  margin-top: 20px;
}

</style>
