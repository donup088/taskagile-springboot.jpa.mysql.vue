export const user = state => state.user
// export const user = state => { return { name: '동그라미' } }

export const hasBoards = state => {
  return state.boards.length > 0
}

export const personalBoards = state => {
  return state.boards.filter(board => board.teamId === 0)
}

export const teamBoards = state => {
  // const teams = []
  //
  // state.teams.forEach(team => {
  //   teams.push({
  //     id: team.id,
  //     name: team.name,
  //     boards: state.boards.filter(board => board.teamId === team.id)
  //   })
  // })
  //
  // return teams
  return [{
    id: 1,
    name: '새로운 팀',
    boards: [{
      id: 2,
      name: '새로운 팀의 보드',
      description: '새로운 팀의 보드'
    }, {
      id: 3,
      name: '두번째 보드',
      description: '두번째~'
    }]
  }]
}
