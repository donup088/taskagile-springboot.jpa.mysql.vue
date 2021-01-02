import axios from 'axios'

export default {
  /**
   *  보드 생성
   *  param : 보드의 세부사항
   */
  create(detail) {
    return new Promise((resolve, reject) => {
      axios.post('/boards', detail).then(({ data  }) => {
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  }
}
