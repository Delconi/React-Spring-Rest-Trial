import React from 'react';
import ReactDOM from 'react-dom';
import TextField from './textField';

export default React.createClass({
	getInitialState: function() {
		return {
			group: this.props.groupDom
		}
	},
	
	render() {	
		var _that = this;
		
		return <div className="well">
			<h3>Group Name: {this.state.group.label}</h3>
			{
				this.state.group.textFields.map(
						function(textField,i){
							return(
									<TextField tfDom={textField} key={i} onChange={_that.props.onChange} />
							)
						}
				)
			}
		</div>
	}
})