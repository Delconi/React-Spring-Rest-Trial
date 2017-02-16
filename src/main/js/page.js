import React from 'react';
import ReactDOM from 'react-dom';
import Group from './group'

export default React.createClass({
	getInitialState: function() {
		return {
			page: this.props.pageDom
		}
	},

	render() {	
		var _that = this;
		
		return <div className="well">
			<h2>Page Name:{this.state.page.label}</h2>
			{
				this.state.page.formGroups.map(
					function(formGroup,i){
						return(
								<Group groupDom={formGroup} key={i} onChange={_that.props.onChange}/>
						)
					}
				)
			}
		</div>
	}
})