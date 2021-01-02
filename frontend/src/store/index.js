import Vue from 'vue'
import Vuex from 'vuex'
import * as getters from './getter'
import * as actions from './action'
import mutations from './mutations'
import createLogger from 'vuex/dist/logger'

Vue.use(Vuex)

const state = {
  user: {
    name: null
  },
  teams: [],
  boards: []
}

export default new Vuex.Store({
  state,
  getters,
  actions,
  mutations,
  plugins: process.env.NODE_ENV !== 'production'
    ? [createLogger()]
    : []
})
