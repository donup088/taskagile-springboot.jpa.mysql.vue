<template>
  <div class="page-header d-flex align-content-center">
    <div class="logo">
      <font-awesome-icon icon="home" class="home-icon" />
      <img class="logo" src="/images/logo.png">
    </div>
    <div class="boards-menu-toggle">
      <div class="dropdown">
        <button class="btn dropdown-toggle" type="button" id="boardsMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Boards
        </button>
        <div class="dropdown-menu" aria-labelledby="boardsMenu">
          <h6 class="dropdown-header">Personal Board</h6>
          <button class="dropdown-item" type="button">새로운 Board</button>
        </div>
      </div>
    </div>
    <div class="search-box flex-fill">
      <div class="search-wrapper">
        <font-awesome-icon icon="search" class="search-icon" />
        <input type="text" placeholder="Search" class="form-control form-control-sm" />
      </div>
    </div>
    <div class="profile-menu-toggle">
      <div class="dropdown">
        <button class="btn dropdown-toggle" type="button" id="profileMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          동그라미
        </button>
        <div class="dropdown-menu" aria-labelledby="profileMenu">
          <button class="dropdown-item" type="button">Profile</button>
          <button class="dropdown-item" type="button">Logout</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import 'bootstrap/dist/js/bootstrap.min'
export default {
  name: 'PageHeader'
}
</script>

<style lang="scss" scoped>
.page-header {
  padding: 9px 10px 8px;
  border-bottom: 1px solid #eee;
  .logo {
    color: #444;
    height: 25px;
    margin-top: 2px;
    margin-bottom: 5px;
    .home-icon {
      font-size: 25px;
      vertical-align: middle;
    }
    img {
      margin-left: 5px;
      width: 100px;
      height: 20px;
    }
  }
  .boards-menu-toggle {
    padding-left: 20px;
    width: 100px;
  }
  .profile-menu-toggle {
    width: 215px;
    text-align: right;
  }
  .search-box {
    .search-wrapper {
      width: 300px;
      margin: 0 auto;
      position: relative;
    }
    .search-icon {
      position: absolute;
      top: 8px;
      left: 8px;
      color: #666;
    }
    input {
      padding-left: 30px;
      height: calc(1.8125rem + 5px);
      font-size: 1rem;
      border: 1px solid #eee;
    }
    input:focus {
      border: 1px solid #377EF6;
    }
  }
}
.dropdown-toggle {
  padding: 2px 5px !important;
}
</style>
